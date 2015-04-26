import httplib

name = raw_input("Name: ");
price = int(raw_input("Price: "));

data = "{\"name\":\"%s\",\"price\":%d}" % (name, price)

conn = httplib.HTTPConnection("localhost:8080")
conn.request("POST", "/", data)

response = conn.getresponse()
#print str(response.status) + " " + response.reason
print response.read()
