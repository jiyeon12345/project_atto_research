<template>
  <div>
    <ProjectRegister
      @isDuplicatedHostName="isDuplicatedHostName"
      @isDuplicatedIp="isDuplicatedIp"
      @submitData="submitData"
    />
  </div>
</template>
<script>
import ProjectRegister from "@/components/ProjectRegister.vue";
import axios from "axios";

export default {
  name: "ProjectRegisterPage",
  components: { ProjectRegister },
  methods: {
    isDuplicatedHostName(payload) {
      let hostName = payload;

      axios
        .get(`http://localhost:7777/project/checkHostName/${hostName}`)
        .then((res) => {
          if (res.data == true) {
            alert("중복된 이름입니다.");
          } else alert("사용 가능한 이름입니다.");
        })
        .catch(() => {
          alert("조회 실패");
        });
    },
    isDuplicatedIp(payload) {
      let ip = payload;

      axios
        .get(`http://localhost:7777/project/checkIp/${ip}`)
        .then((res) => {
          if (res.data == true) {
            alert("중복된 ip 입니다.");
          } else alert("사용 가능한 ip입니다.");
        })
        .catch(() => {
          alert("조회 실패");
        });
    },
    submitData(payload) {
      const { hostName, ip } = payload;
      axios
        .post(`http://localhost:7777/project/sign-up`, { hostName, ip })
        .then((res) => {
          if (res.data == 0) {
            alert("등록을 완료했습니다.");
            return this.$router.push({ name: "ProjectMain" });
          }
          if (res.data == 1) {
            alert("등록된 수가 100개를 넘었습니다.");
            return this.$router.push({ name: "ProjectMain" });
          }
          if (res.data == 2)
            return alert("중복검사를 다시 해 주시기 바랍니다.");
          if (res.data == 3) return alert("값을 모두 입력해 주시기 바랍니다.");
        })
        .catch(() => {
          alert("등록에 실패하였습니다.");
        });
    },
  },
};
</script>
<style lang=""></style>
