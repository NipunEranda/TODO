<template>
    <div>
        <input type="text" placeholder="Username" v-model="username" />
        <input type="password" placeholder="Password" v-model="password">
        <button @click="login">Google</button>
    </div>
</template>

<script setup lang="ts">

import axios from 'axios';
import { ref } from 'vue';

let username = ref(null),
    password = ref(null);
function login() {
    axios.post(`http://localhost:8888/api/user/login`, { "username": username.value, "password": password.value }, { withCredentials: true }).then(response => {
        console.log(response);
    });
}
</script>