<template>
    <div>
        <button @click="login">Google</button>
    </div>
</template>

<script setup lang="ts">
function login() {
    window.location.href = 'http://localhost:8888/oauth2/authorization/google'
}
</script>