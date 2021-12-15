<template>
<div id="app" class="app">

<div class="header">

<h1>Vitrineando.Com</h1>

    <nav>
        <button class="btn btn-one" v-if="!is_auth" v-on:click="loadLogin" > Iniciar Sesion</button>
        <button class="btn btn-one" v-if="!is_auth" v-on:click="loadSignUp" > Crear Cuenta</button>
        <button v-if="is_auth" v-on:click="loadHome" > Inicio </button>
        <button v-if="is_auth" v-on:click="logOut"> Cerrar Sesión </button>
        <button v-if="is_auth" v-on:click="loadPublication"> Publicacion </button>
        <!--<button v-if="is_auth" v-on:click="loadVecinos"> Tus Vecinos </button>
        <button v-if="is_auth" v-on:click="loadUpdate"> Configuracion </button>
        <button v-if="is_auth" v-on:click="loadAccount"> Cuenta </button>
        <button v-if="is_auth" v-on:click="deleteAccount" > Eliminar </button>
        -->
        
    </nav>

</div>
  <div class="main-component">
    <router-view
    v-on:completedLogIn="completedLogIn"
    v-on:completedSignUp="completedSignUp"
    >
    </router-view>
  </div>

<div class="footer">
<h2>Misión TIC 2021</h2>
</div>
</div>
</template>

<script>

import Swal from 'sweetalert2';
import axios from 'axios'
import jwt_decode from "jwt-decode"

export default{

  name: 'App',

  data: function(){
    return{
      is_auth: false
}
},
  components: {
      
  },

  methods:{
    verifyAuth: function() {
    if(this.is_auth == false)
    this.$router.push({name: "logIn"})
    },
    loadLogin(){
      this.$router.push({name: "logIn"})
    },
    loadSignUp: function(){
      this.$router.push({name: "signUp"})
    },
    completedLogIn: function(data) {},
    completedSignUp: function(data) {},
},
  created: function(){
    this.verifyAuth()
  }
}
</script>


<style>
body{
margin:0 0 0 0;

}
.header{
margin:0%;
padding:0;
width: 100%;
height: 10vh;
min-height: 90px;

background-color: #FFD700;

color:#283747;
display: flex;
justify-content: space-between;
align-items: center;
}
.header h1{
width: 20%;
text-align: center;
}

.header nav{
    height: 100%;
    width: 20%;
    display: flex;
    justify-content: space-around;
    align-items: center;
    font-size: 20px;
  }

  .header nav button{
    color: #E5E7E9;
    background: #0051bbd8;
    
    border-radius: 25px;
    padding: 10px 20px;
  }

  .header nav button:hover{
    color: #283747;
    background: none;
    
  }

  .main-component{
    height: 70vh;
    margin: 0%;
    padding: 0%;
    background: #4169E1;
    /*background-image: url("https://ikigaimatsuri.com/wp-content/uploads/2017/08/Sekirei.jpg");
    background-size: 100%;
    background-position-y: 60%;*/
  }
  .footer{
   margin: 0%;
    padding: 0;
    width: 100%;
    height: 10vh;
    min-height: 78px;

    background-color: #B22222 ;
    color:#e5e9e8 ;
  }
  .footer h2{
    width: 100%;
    height: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .btn-one {
	color: #FFF;
	transition: all 0.3s;
	position: relative;
}
.btn-one span {
	transition: all 0.3s;
}
.btn-one::before {
	content: '';
	position: absolute;
	bottom: 0;
	left: 0;
	width: 100%;
	height: 100%;
	z-index: 1;
	opacity: 0;
	transition: all 0.3s;
	border-top-width: 1px;
	border-bottom-width: 1px;
	border-top-style: solid;
	border-bottom-style: solid;
	border-top-color: rgba(255,255,255,0.5);
	border-bottom-color: rgba(255,255,255,0.5);
	transform: scale(0.1, 1);
}
.btn-one:hover span {
	letter-spacing: 2px;
}
.btn-one:hover::before {
	opacity: 1;	
	transform: scale(1, 1);	
}
.btn-one::after {
	content: '';
	position: absolute;
	bottom: 0;
	left: 0;
	width: 100%;
	height: 100%;
	z-index: 1;
	transition: all 0.3s;
	background-color: rgba(255,255,255,0.1);
}
.btn-one:hover::after {
	opacity: 0;	
	transform: scale(0.1, 1);
}
</style>