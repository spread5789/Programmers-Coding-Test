문제
==
![1](https://user-images.githubusercontent.com/73854324/158373015-2c180dc5-f868-4051-b144-2405b05e134e.png)
<br><br>
==

<br><br>
![2](https://user-images.githubusercontent.com/73854324/158373020-a8871716-1bf8-417e-a92b-8ec053882cd9.png)<br>
접속 시, vuln flag login 3 곳의 링크가 있고, 로그인을 해달라고 한다.   
우선 페이지를 살펴보자.   
<br><br>
![3](https://user-images.githubusercontent.com/73854324/158373021-4608f9b7-b753-43f2-aec9-4773e3068287.png)<br>
vuln 페이지이다.   
우선 가장 먼저 보이는 점은, alert 스크립트를 실행했지만 '&#42;' 문자로 처리 된 점이다.   
<br><br>
![4](https://user-images.githubusercontent.com/73854324/158373024-24c6511a-f9c4-4ba1-9b6a-25dc78b95bf1.png)<br>
flag 페이지이다. vuln 페이지를 이용하여 CSRF 공격을 해야 할 것으로 보인다.   
<br><br>
![5](https://user-images.githubusercontent.com/73854324/158373025-afdf26dd-7905-44dc-8685-9b7d5745ad93.png)<br>
로그인 페이지이다.   
우선 계정을 모르니 소스코드를 살펴보았지만 힌트는 없었다.   
따라서 문제에서 배포해준 코드를 살펴봐야겠다.   
<br><br>
![6](https://user-images.githubusercontent.com/73854324/158373030-6c46a3ee-0c2c-4fe2-a54c-6cc9cb21c0cd.png)<br>
계정 정보가 들어있다.   
guest/guest 로 로그인이 가능 할 것으로 보이며, admin 계정의 비밀번호는 flag.txt 파일의 값이다.   
<br><br>
![7](https://user-images.githubusercontent.com/73854324/158373032-61bb78c6-85f8-45fb-a3ff-328a7451051b.png)<br>
먼저, guest 계정으로 로그인을 시도하였다.   
이 쯤에서, 다시 코드를 살펴봐야 할 필요가 있어보였다.   
<br><br>

```
try:
    FLAG = open("./flag.txt", "r").read()
except:
    FLAG = "[**FLAG**]"

users = {
    'guest': 'guest',
    'admin': FLAG
}

session_storage = {}

def read_url(url, cookie={"name": "name", "value": "value"}):
    cookie.update({"domain": "127.0.0.1"})
    try:
        options = webdriver.ChromeOptions()
        for _ in [
            "headless",
            "window-size=1920x1080",
            "disable-gpu",
            "no-sandbox",
            "disable-dev-shm-usage",
        ]:
            options.add_argument(_)
        driver = webdriver.Chrome("/chromedriver", options=options)
        driver.implicitly_wait(3)
        driver.set_page_load_timeout(3)
        driver.get("http://127.0.0.1:8000/")
        driver.add_cookie(cookie)
        driver.get(url)
    except Exception as e:
        driver.quit()
        print(str(e))
        # return str(e)
        return False
    driver.quit()
    return True


def check_csrf(param, cookie={"name": "name", "value": "value"}):
    url = f"http://127.0.0.1:8000/vuln?param={urllib.parse.quote(param)}"
    return read_url(url, cookie)


@app.route("/")
def index():
    session_id = request.cookies.get('sessionid', None)
    try:
        username = session_storage[session_id]
    except KeyError:
        return render_template('index.html', text='please login')

    return render_template('index.html', text=f'Hello {username}, {"flag is " + FLAG if username == "admin" else "you are not an admin"}')


@app.route("/vuln")
def vuln():
    param = request.args.get("param", "").lower()
    xss_filter = ["frame", "script", "on"]
    for _ in xss_filter:
        param = param.replace(_, "*")
    return param


@app.route("/flag", methods=["GET", "POST"])
def flag():
    if request.method == "GET":
        return render_template("flag.html")
    elif request.method == "POST":
        param = request.form.get("param", "")
        session_id = os.urandom(16).hex()
        session_storage[session_id] = 'admin'
        if not check_csrf(param, {"name":"sessionid", "value": session_id}):
            return '<script>alert("wrong??");history.go(-1);</script>'

        return '<script>alert("good");history.go(-1);</script>'


@app.route('/login', methods=['GET', 'POST'])
def login():
    if request.method == 'GET':
        return render_template('login.html')
    elif request.method == 'POST':
        username = request.form.get('username')
        password = request.form.get('password')
        try:
            pw = users[username]
        except:
            return '<script>alert("not found user");history.go(-1);</script>'
        if pw == password:
            resp = make_response(redirect(url_for('index')) )
            session_id = os.urandom(8).hex()
            session_storage[session_id] = username
            resp.set_cookie('sessionid', session_id)
            return resp 
        return '<script>alert("wrong password");history.go(-1);</script>'


@app.route("/change_password")
def change_password():
    pw = request.args.get("pw", "")
    session_id = request.cookies.get('sessionid', None)
    try:
        username = session_storage[session_id]
    except KeyError:
        return render_template('index.html', text='please login')

    users[username] = pw
    return 'Done'

app.run(host="0.0.0.0", port=8000)
```

가장 하단에, change_password 라는 페이지가 있었다.   
우선 접속을 해보았다.   
<br><br>
![8](https://user-images.githubusercontent.com/73854324/158374014-d36f15e3-d2fe-4e3b-8442-ddddd39179df.png)<br>
Done 밖에 뜨질 않는다.   
<br><br>

```
@app.route("/change_password")
def change_password():
    pw = request.args.get("pw", "")
    session_id = request.cookies.get('sessionid', None)
    try:
        username = session_storage[session_id]
    except KeyError:
        return render_template('index.html', text='please login')

    users[username] = pw
    return 'Done'

app.run(host="0.0.0.0", port=8000)
```

다시 코드를 살펴보면, pw 라는 파라미터 명으로 값을 받고   
sessionid 라는 이름의 쿠키를 가져온다. 없을 경우 None[기본] 값을 받는다.   
   
그 후, 세션 저장소에서 sessionid 에 해당하는 값을 username 으로 처리하고, users[username] = pw 를 넣는다.   
즉, users[username] = request.args.get("pw", "") 이 된다.   
<br>

## 정리하면, change_password 페이지로 인해 암호가 바뀔경우, pw 파라미터 값이 비밀번호가 된다.   

```
@app.route("/")
def index():
    session_id = request.cookies.get('sessionid', None)
    try:
        username = session_storage[session_id]
    except KeyError:
        return render_template('index.html', text='please login')

    return render_template('index.html', text=f'Hello {username}, {"flag is " + FLAG if username == "admin" else "you are not an admin"}')
```

루트페이지 설정에는 username 이 admin일 경우, Hello username 이 아닌, flag 값이 뜨도록 되어있다.   
따라서, admin 계정으로 change_password 페이지로 방문하도록 한다면 암호를 변경하여 로그인에 성공할 수 있다.   
<br><br>
```
@app.route("/flag", methods=["GET", "POST"])
def flag():
    if request.method == "GET":
        return render_template("flag.html")
    elif request.method == "POST":
        param = request.form.get("param", "")
        session_id = os.urandom(16).hex()
        session_storage[session_id] = 'admin'
        if not check_csrf(param, {"name":"sessionid", "value": session_id}):
            return '<script>alert("wrong??");history.go(-1);</script>'

        return '<script>alert("good");history.go(-1);</script>'
		

def check_csrf(param, cookie={"name": "name", "value": "value"}):
    url = f"http://127.0.0.1:8000/vuln?param={urllib.parse.quote(param)}"
    return read_url(url, cookie)
```

flag 페이지, check_csrf 함수이다.   
check_csrf 함수는, 쿠키값을 설정하고 param 경로로 접속하는데, read_url 함수가 봇이 접속하는 함수이다.
<br><br>
flag 페이지는 POST 요청을 받으면, sessionid 라는 쿠키이름과 session_id 라는 쿠키값을 check_csrf 함수에 넘겨준다.   
그 후, param 주소에 상대경로로 접속하게된다.   
이때, session_storage[session_id] = 'admin' 에 의해, admin 으로 접속할 것이다.   
<br><br>
그러면 flag 를 획득 할 방법이 보인다.   
전체적으로 흐름을 보자면, flag 페이지에 파라미터를 넘겨주고 해당 파라미터 주소에 드라이버를 이용하여(봇이) admin 계정으로 접속하는 방식이다.   
<br>
flag 페이지에 change_password 페이지에 접속하도록 유도하면서, pw 파라미터명에는 내가 원하는 비밀번호를 적어주면 된다.   
<br><br>

```
@app.route("/vuln")
def vuln():
    param = request.args.get("param", "").lower()
    xss_filter = ["frame", "script", "on"]
    for _ in xss_filter:
        param = param.replace(_, "*")
    return param
```

vuln 페이지를 이용하여 csrf 요청을 하면 되는데,   
입력받은 파라미터 값은 소문자로 변환되고 frame, script, on 문자는 '&#42;' 문자로 처리 되는 부분이 있다.   
그래서 처음에 alert 이 먹히질 않았다.   
<br><br>
![9](https://user-images.githubusercontent.com/73854324/158377720-bba92466-b6f1-4879-98e5-974b91100224.png)<br>
내가 생각한 것은, img 태그를 이용하는 것이다.   

```
<img src='/change_password?pw=admin'>
```

정도면 필터링 되지도 않고, 암호도 admin 으로 바꿀 수 있으니 일단 시도해보았다.   
<br><br>

![10](https://user-images.githubusercontent.com/73854324/158377726-6ea1c16d-8db4-48b9-8078-366dc1be6dab.png)<br>
![11](https://user-images.githubusercontent.com/73854324/158377730-2e1b444e-ffd8-4fee-b0a3-28968f54b090.png)<br>
![12](https://user-images.githubusercontent.com/73854324/158377733-aec75869-fb81-4228-8ae5-1edbf60c60f8.png)<br>
손 쉽게 flag 값 획득 성공