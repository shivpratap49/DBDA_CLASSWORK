# django
# - package used to develop websites using python
# - most of the times, uses the flask behind the scene
# - it also uses html, js and css for website development

# website
# - is also known as web application
# - developed using html/css and JS
# - it has GUI which is designed using HTML and decorated using CSS
# - mainly developed for end users
# - requires browser to see the GUI

# web services
# - used for providing data (from different sources) to the websites or
#   mobile applications
# - also known as middleware (as it sits in middle of website and data source)
# - it does not have any GUI
# - not developed for end users, rather they are developed for developers
# - multiple standards can be used to develop web services
#   - SOAP: Simple Object Access Protocol (uses XML for communication)
#   - REST: REpresentational State Transfer (uses JSON for communication)
#   - GraphQL: Graph Query Language (faster than REST)
#   - gRPC: Remote Procedure Call (faster than GraphQL)

# flask
# - package used to develop web services using REST design pattern
# - it is a community package (not installed by default)
# - it has to be explicitly installed using pip3 (linux/mac)
#   or pip (win) command
# - > pip3 install flask
# - > pip install flask
# - flask uses REST design pattern


# REST
# - REpresentational State Transfer
# - design pattern which is developed on top of web architecture
# - resource
#   - any file / record stored on the server
# - URL
#   - uniform resource locator
# - includes
#   - http request
#     - gets created by client
#     - contains
#       - header
#         - collection of key-value pairs
#         - like:
#           - http method
#             - GET: used to get a resource from the server
#             - POST: used to create/send a resource on the server
#             - PUT: used to update a resource on the server
#             - DELETE: used to delete a resource on the server
#           - url or path
#             - used to identify the type of request
#       - body
#         - contains the data to be sent to the server
#           (in case of method POST and PUT)
#   - http response
#     - server creates the response to send the requested data to the client
#     - contains
#       - header
#         - contains collection of key-value pairs
#         - like:
#           - status code: used to let the client know about the
#             request execution result
#             - 200: OK
#             - 404: resource not found
#           - content-length: length of the data present in body
#       - body
#         - used to send the data to the client
#         - contains the requested resource
