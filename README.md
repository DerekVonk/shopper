# shopper
Assessment 


### Running the Project

- First, you need a redis server running on the default port
- To run the project:
  - copy the appliction-config folder to c:\Users\{username}\ on Windows or /home/{username}/ on *nix. Then open a git bash terminal in application-config and run:
    - git init
    - git add .
    - git commit -m "First commit"
  - start the config-server
  - start the discovery-server
  - start all the other servers in any order (gateway-server, product-service)
