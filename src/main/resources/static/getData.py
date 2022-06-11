import urllib.request
import re
import random
# 设置爬虫header，伪装成浏览器
headers = {
    'user-agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36'
}
# url，网址
url = 'https://book.douban.com/top250'
# 通过request类来构造请求
res = urllib.request.Request(url, headers=headers)
# 通过urlopen方法访问页面并返回 HTTPResposne 对象
response = urllib.request.urlopen(res)
# 通过read()方法读取字节流并解码成字符串
html = response.read().decode('utf-8')

# print(html)
regex = """(?:<a href="https://book.douban.com/subject/.+title=)(?:")(.+)(?:")"""
name = re.findall(regex, html)
regex = """(?:<p class="pl">)(.+?)/"""
author= re.findall(regex, html)
regex = """<span class="inq">(.+?)</span>"""
remark= re.findall(regex, html)
price = [random.randint(30,300) for i in range(len(name))]
bookNumber = [random.randint(500,3000) for i in range(len(name))]
borrowNumber = [random.randint(0,bn) for bn in bookNumber]
for i in range(len(name)):
    print("('%s','%s',%s,%s,%s,%s,'%s')," % (name[i],author[i],price[i],"'XX出版社'",bookNumber[i],borrowNumber[i],remark[i]),end='\n')
