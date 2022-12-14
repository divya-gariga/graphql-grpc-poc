const grpc = require("@grpc/grpc-js");
const { Empty, Todo } = require("./proto/todos_pb");

var protoLoader = require("@grpc/proto-loader");
const { AppClient } = require("./proto/todos_grpc_pb");

const client = new AppClient(
  "13.58.43.162:80",
  grpc.credentials.createInsecure()
);

module.exports = client;
