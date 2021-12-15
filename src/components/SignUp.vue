<template>
    <div class="signUp_user">
        <div class="container_signUp_user">
            <h1>Registrarse</h1>

            <form v-on:submit.prevent="processSignUp" >
                <input type="text" v-model="user.username" placeholder="Usuario">
                <br>

                <input type="email" v-model="user.email" placeholder="Email">
                <br>

                <input type="number" v-model="user.celular" placeholder="Celular">
                <br>

                <input type="text" v-model="user.name" placeholder="Direccion">
                <br>

                <input type="password" v-model="user.password" placeholder="Contraseña">
                <br>

                <button type="submit">Registrarse</button>
            </form>
        </div>
    </div>
</template>

<script>
import axios from 'axios';
import gql from "graphql-tag";

export default {
    name: "SignUp",

    data: function(){
        return {
            user: {
                username: "",
                name: "",
                celular: "",
                email: "",
                direccion:"",
                password: "",
            }
        }
    },

    methods: {
        processSignUp: function(){
            await this.$apollo
        .mutate({
          mutation: gql`
            mutation($userInput: SignUpInput!) {
              signUpUser(userInput: $userInput) {
                refresh
                access
              }
            }
          `,
          variables: {
            userInput: this.user,
          },
        })
        .then((result) => {
          let dataLogIn = {
            username: this.user.username,
            token_access: result.data.signUpUser.access,
            token_refresh: result.data.signUpUser.refresh,
          };

          this.$emit("completedSignUp", dataLogIn);
        })
        .catch((error) => {
          alert("ERROR: Fallo en el registro.");
        });
        }
    }
}
</script>

<style>

    .signUp_user{
        margin: 0;
        padding: 0%;
        height: 100%;
        width: 100%;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .container_signUp_user {
        border: 3px solid #283747;
        border-radius: 10px;
        backdrop-filter: blur(80px);
        width: 25%;
        height: 76%;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }

    .signUp_user h1{
        color: #283747;
    }

    .signUp_user form{
        width: 70%;
    }

    .signUp_user input{
        height: 40px;
        width: 100%;
        box-sizing: border-box;
        padding: 10px 20px;
        margin: 5px0;
        border: 1px solid #283747;
    }
    
    .signUp_user button{
        width: 100%;
        height: 40px;
        color: #E5E7E9;
        background: #283747;
        border: 1px solid #E5E7E9;
        border-radius: 5px;
        padding: 10px 25px;
        margin: 5px0 25px0;
    }

    .signUp_user button:hover{
        color: #E5E7E9;
        background: crimson;
        transition-duration: 8ms;
        transition: ease-in-out;
        border: 1px solid #283747;
    }
</style>