import { createRouter, createWebHistory } from 'vue-router'
import App from './App.vue'

import Login from './components/Login.vue'
import SignUp from './components/SignUp.vue'
/*import Home from './components/Home.vue'
import Account from './components/Account.vue'
import Update from './components/Update.vue'
import Publication from './components/Publication.vue'
import Vecinos from './components/Vecinos.vue'
*/

const routes = [{
  path: '/',
  name: 'root',
  component: App
  },
  {
    path: '/user/logIn',
    name: 'logIn',
    component: Login
  },
  {
    path: '/user/signUp',
    name: 'signUp',
    component: SignUp
  },/*
  {
    path: '/user/home',
    name: 'home',
    component: Home
  },
  {
    path: '/user/account',
    name: "account",
    component: Account
  },
  {
    path: '/user/update',
    name: "update",
    component: Update
  },
  {
    path: '/publication',
    name: "publication",
    component: Publication
  },
  {
    path: '/vecinos',
    name: "vecinos",
    component: Vecinos
  },*/
]

const router = createRouter({
  history: createWebHistory(),
  routes
  })
export default router