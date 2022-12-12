const grpc = require("@grpc/grpc-js");
const { Empty, Todo } = require("./proto/todos_pb");

var protoLoader = require("@grpc/proto-loader");
const { AppClient } = require("./proto/todos_grpc_pb");

const client = new AppClient(
  "localhost:9090",
  grpc.credentials.createInsecure()
);

module.exports = client;
