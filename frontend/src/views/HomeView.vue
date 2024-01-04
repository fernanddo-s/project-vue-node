<script setup lang="ts">
const constant = {
  tableHeader:[
    { title: "Codigo", align: "start", sortable: true, key: "codigo" },
    { title: "Nome", align: "start", sortable: true, key: "nome" },
    { title: "Descrição", align: "start", sortable: true, key: "descricao" },
    { title: "", sortable: false, key: "id" },
  ]
}
</script>

<template>
  <h1>Tabela</h1>
  <v-card-text>
    <v-data-table-server :headers="constant.tableHeader">

    </v-data-table-server>
  </v-card-text>
</template>