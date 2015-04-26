import httplib

conn = httplib.HTTPConnection("localhost:8080")
conn.request("GET", "/")

response = conn.getresponse()
#print str(response.status) + " " + response.reason
print response.read()
