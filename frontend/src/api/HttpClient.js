import axios from "axios";

const httpClient = axios.create({
  baseURL: "http://localhost:8800",
  timeout: 1000,
});

export default httpClient;