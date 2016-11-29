FROM node:4

# User data directory, contains flows, config and nodes.
#RUN mkdir /data

# grunt package
RUN npm install -g grunt-cli

# http-server for starting server without a server.js (http-server -p 80)
RUN npm install http-server -g

RUN git clone https://github.com/Freeboard/freeboard.git
WORKDIR /freeboard

RUN npm install

RUN grunt

## User configuration directory volume
#EXPOSE 80

CMD ["http-server", "-p", "80"]