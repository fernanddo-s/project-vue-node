import httpClient from "@/api/HttpClient";

export default {
  async  findAll() {
    const { data } = await httpClient({
      method: 'get',
      url: '/',
    })
    return data;
  },

  async create(user) {
    const response = await httpClient.post(`/`, user);
    return response.data;
  },
}
