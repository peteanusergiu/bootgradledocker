//Lets require/import the HTTP module
var http = require('http');
    fs = require('fs');

//Lets define a port we want to listen to
const PORT=8080;

//We need a function which handles requests and send response
function handleRequest(request, response){
    var fileStream = fs.createReadStream('./index.html');
    fileStream.pipe(response);
}


/*
app.get("/", function(req, res)
{
    res.sendFile("index.html", {"root": __dirname});
});
*/

//Create a server
//var server = http.createServer(handleRequest);
var server = http.createServer(handleRequest)

//Lets start our server
server.listen(PORT, function(){
    //Callback triggered when server is successfully listening. Hurray!
    console.log("Server listening on: http://localhost:%s", PORT);
});