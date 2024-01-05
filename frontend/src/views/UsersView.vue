<script setup>
import axios from "axios";
import { reactive } from "vue";

const state = reactive({
  id: 0,
  edit: false,
  user: {
    nome: '',
    email: '',
    telefone: '',
    idade: 0,
  },
  userEdit: {
    nome: '',
    email: '',
    telefone: '',
    idade: 0,
  },
  usersList: [],
  dialog: false,
  emailRules: [
    value => {
      if (value) {
        return true
      }
      return 'E-mail é obrigatório!'
    },
    value => {
      if (value.includes('@')) {
        return true
      }
      return 'E-mail inválido!'
    }
  ]
})

const getUsers = async () => {
  try {
    const res = await axios.get("http://localhost:8800")
    state.usersList = res.data;
  }
  catch (error) {
    console.log(error)
  }
}

const addUser = async () => {
  try {
    await axios.post("http://localhost:8800", state.user)
    clearForm()
    getUsers();
  }
  catch (error) {
    console.log(error)
  }
}

function clearForm() {
  state.user.nome = ''
  state.user.email = ''
  state.user.telefone = ''
  state.user.idade = 0
}

async function updateUser(id) {
  try {
    state.dialog = true
    await axios.put("http://localhost:8800/" + id, {
      nome: state.user.nome,
      email: state.user.email,
      telefone: state.user.telefone,
      idade: state.user.idade
    });
    clearForm();
    getUsers();
  }
  catch (error) {
    console.error(error)
  }
}

async function deleteUser(id) {
  try {
    await axios.delete(`http://localhost:8800/${id}`);
    getUsers();
  }
  catch (error) {
    console.error(error)
  }
}

function openDialog(user) {
  if (user == null) {
    state.user = {
      nome: '',
      email: '',
      telefone: '',
      idade: 0,
    }
  } else {
    state.userEdit = user
  }
  state.dialog = true;
}

function closeDialog() {
  state.user = {
    nome: '',
    email: '',
    telefone: '',
    idade: 0,
  }
  state.dialog = false;
}

const headers = [
  { title: "Nome", align: "start", sortable: true, key: "nome" },
  { title: "E-mail", align: "start", sortable: true, key: "email" },
  { title: "Telefone", align: "start", sortable: true, key: "telefone" },
  { title: "Idade", align: "start", sortable: true, key: "idade" },
  { title: "", sortable: false, key: "id" }
]
const itemsPerPageOptions = [
  { title: "5", value: 5 },
  { title: "10", value: 10 },
  { title: "25", value: 25 },
  { title: "50", value: 50 },
  { title: "100", value: 100 },
]

function save() {
  if (state.edit) {
    updateUser(state.id);
  } else {
    addUser();
  }
  state.dialog = false
}

</script>

<template>
  <v-card>
    <v-toolbar dense color="primary">
      <v-toolbar-title>Controle de Usuários</v-toolbar-title>
    </v-toolbar>
    <v-card-title>
      <v-btn class="mt-4 mx-2 px-2 py-5 d-flex justify-content align-center" color="primary" elevation="0"
        @click="state.edit = false, openDialog()">
        Adicionar Usuário
      </v-btn>
      <v-dialog v-model="state.dialog" width="70%" persistent="true">
        <v-card>
          <v-card-title>Informe os dados do usuário</v-card-title>
          <v-card-text>
            <v-row>
              <v-col>
                <v-text-field type="text" label="Nome" variant="outlined" v-model="state.user.nome"></v-text-field>
              </v-col>
              <v-col>
                <v-text-field type="email" label="E-mail" variant="outlined" :rules="state.emailRules"
                  placeholder="user@email.com" v-model="state.user.email"></v-text-field>
              </v-col>
            </v-row>
            <v-row>
              <v-col>
                <v-text-field type="text" label="Telefone" variant="outlined"
                  v-model="state.user.telefone"></v-text-field>
              </v-col>
              <v-col>
                <v-text-field type="number" label="Idade" variant="outlined" v-model="state.user.idade"></v-text-field>
              </v-col>
            </v-row>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn variant="text" @click="closeDialog()">Cancelar</v-btn>
            <v-btn variant="tonal" color="blue" @click="save()">Salvar</v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-card-title>

    <v-card-text>
      <v-data-table :items="state.usersList" :items-per-page-options="itemsPerPageOptions" :headers="headers"
        @update:options="getUsers()">
        <template v-slot:item="{ item }">
          <tr>
            <td>{{ item.nome }}</td>
            <td>{{ item.email }}</td>
            <td>{{ item.telefone }}</td>
            <td>{{ item.idade }}</td>
            <td>
              <v-btn icon="mdi-pencil" variant="text" color="info"
                @click="state.edit = true, state.id = item.id, openDialog(item)"></v-btn>
              <v-btn icon="mdi-delete" variant="text" color="error" @click="deleteUser(item.id)"></v-btn>
            </td>
          </tr>
        </template>
      </v-data-table>
    </v-card-text>
  </v-card>
</template>
