const {ApolloServer}=require("apollo-server");
const { gql } = require("apollo-server");
const {Query}=require("./resolvers/Query")
const {typeDefs}=require("./schema")
const {Mutation}=require("./resolvers/Query")

// const {grpc} = require('../proto');

const context = ({ req }) => {
    return {
        headers: req.headers,
    };
}

const server=new ApolloServer({
    typeDefs,
    resolvers:{
        Query,
        Mutation
    },
    context
});

server.listen().then(({ url }) => {
    console.log(`🚀  Server ready at ${url}`);
  }); 