import React from "react";
import ReactDOM from "react-dom";
import "./index.css";
import App from "./App";
import {
  ApolloClient,
  InMemoryCache,
  ApolloProvider,
  HttpLink,
  from,
  gql,
} from "@apollo/client";
import { onError } from "@apollo/client/link/error";

const errorLink = onError(({ graphqlErrors, networkError }) => {
  if (graphqlErrors) {
    graphqlErrors.map(({ message, location, path }) => {
      alert(`Graphql error ${message}`);
    });
  }
});
const link = from([
  errorLink,
  new HttpLink({ uri: "http://18.223.109.95:80/graphql" }),
]);
const client = new ApolloClient({
  cache: new InMemoryCache(),
  link: link,
});
const root = ReactDOM.createRoot(document.getElementById("root"));

const DATA = [
  { id: "todo-0", name: "x", completed: true },
  { id: "todo-1", name: "y", completed: false },
  { id: "todo-2", name: "z", completed: false },
];

root.render(
  <ApolloProvider client={client}>
    <App tasks={DATA} />
  </ApolloProvider>
);
