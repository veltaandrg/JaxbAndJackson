import httplib

name = raw_input("Name: ");

conn = httplib.HTTPConnection("localhost:8080")
conn.request("GET", "/?name=" + name)

response = conn.getresponse()
#print str(response.status) + " " + response.reason
print response.read()
