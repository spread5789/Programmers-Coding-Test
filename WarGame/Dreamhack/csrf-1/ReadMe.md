문제
==
![1](https://user-images.githubusercontent.com/73854324/158381653-d7ddd3aa-7501-42e7-b12d-603ad7bb1eaf.png)
<br><br>
==

<br><br>
![2](https://user-images.githubusercontent.com/73854324/158381657-10ecf682-44d1-4eec-b89a-958d674e38b9.png)<br>
페이지는 4 개가 있다.      
<br><br>
![3](https://user-images.githubusercontent.com/73854324/158381661-838efa7a-27aa-4c53-9011-e1cc7f6750f1.png)<br>
vuln 페이지이다.   
csrf-2 와 마찬가지로, xss 공격을 방지하고 csrf 로 풀라는 의미로 치환처리 되어있는 것 같다.   
<br><br>
![4](https://user-images.githubusercontent.com/73854324/158381662-072cd384-5e5c-4274-9a15-4b071dfc4adf.png)<br>
memo 페이지이다.   
사용자가 파라미터로 전달한 값이 계속 추가되는 형식이다.   
<br><br>
![5](https://user-images.githubusercontent.com/73854324/158381663-e2b4fceb-7b71-4d79-964b-d5f7eaa5c7d5.png)<br>
notice flag 페이지인데, Access Denied 가 떳다.   
내가 접속할 수 있는 페이지가 아닌가보다.   
<br><br>
![6](https://user-images.githubusercontent.com/73854324/158381668-d4beaf92-fd29-4576-809e-7ea92bef7592.png)<br>
flag 페이지, 이전과 마찬가지로 이 곳에 스크립트를 넣으면 봇이 접속 할 것이다.   
<br><br>
![7](https://user-images.githubusercontent.com/73854324/158381670-f4acc3e7-b944-414d-b716-67a7cca7264a.png)<br>
딱히 할 수 있는건 없어보여서 소스를 살펴보았다.   
해답은 notice flag 페이지에 있었다.   
조건1 : 127.0.0.1 ip 일 것.   
조건2 : userid 파라미터값이 admin 일 것.   
<br>
내가 접속하는건 아니고, 로컬 사용자가 admin 으로 접속하면 flag 를 뱉는 것 같다.   
<br><br>
![8](https://user-images.githubusercontent.com/73854324/158381673-7a44b691-dad2-47c3-8c90-54ae079aca13.png)<br>
그러면.. 그냥 flag 페이지에 바로 넣어보았다.   

```
<img src='/admin/notife_flag?userid=admin'>
```

<br>

![9](https://user-images.githubusercontent.com/73854324/158381676-8a6df46b-325b-40b0-844b-6bfe62953eb8.png)<br>

![10](https://user-images.githubusercontent.com/73854324/158381677-33724e13-232a-481b-b4fd-1ccf52cb84c6.png)<br>
csrf-2 를 먼저 풀고와서 금방 풀었다.   
하단은 문제 코드인데 별 거 없다.   

<br><br>

```
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
    return render_template("index.html")


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
        if not check_csrf(param):
            return '<script>alert("wrong??");history.go(-1);</script>'

        return '<script>alert("good");history.go(-1);</script>'


memo_text = ""


@app.route("/memo")
def memo():
    global memo_text
    text = request.args.get("memo", None)
    if text:
        memo_text += text
    return render_template("memo.html", memo=memo_text)


@app.route("/admin/notice_flag")
def admin_notice_flag():
    global memo_text
    if request.remote_addr != "127.0.0.1":
        return "Access Denied"
    if request.args.get("userid", "") != "admin":
        return "Access Denied 2"
    memo_text += f"[Notice] flag is {FLAG}\n"
    return "Ok"


app.run(host="0.0.0.0", port=8000)
```

전체 코드는 이렇기 때문에, userid=admin 을 해주지 않으면,   
Access Denied 2 를 리턴하고 끝나므로 넣어줘야 memo_text 에 추가된다.   