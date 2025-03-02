import type { RouteRecordRaw } from "vue-router";
import Index from "../views/Index.vue";
import Home from "../views/Home.vue";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    name: "index",
    component: Index,
  },
  {
    path: "/home",
    name: "home",
    component: Home,
  },
];

export default routes;