import Vue from "vue";
import VueRouter from "vue-router";
import ProjectMain from "../views/ProjectMain.vue";
import ProjectRegisterPage from "../views/ProjectRegisterPage.vue";
import ProjectCheckAlivePage from "../views/ProjectCheckAlivePage.vue";
import ProjectReadServerPage from "../views/ProjectReadServerPage.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "ProjectMain",
    component: ProjectMain,
  },
  {
    path: "/register",
    name: "ProjectRegisterPage",
    component: ProjectRegisterPage,
  },
  {
    path: "/check/alive",
    name: "ProjectCheckAlivePage",
    component: ProjectCheckAlivePage,
  },
  {
    path: "/read/alive/:hostName",
    name: "ProjectReadServerPage",
    component: ProjectReadServerPage,
  },
  {
    path: "/about",
    name: "about",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/AboutView.vue"),
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
