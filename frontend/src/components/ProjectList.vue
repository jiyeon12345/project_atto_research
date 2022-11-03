<template>
  <div>
    <table border="1">
      <tr>
        <th align="center" width="100">번호</th>
        <th align="center" width="100">이름</th>
        <th align="center" width="150">IP 주소</th>
        <!-- <th align="center" width="240">alive Ver1</th> -->
        <th align="center" width="240">alive Ver2</th>
        <th align="center" width="240">alive date</th>
        <th align="center" width="240">create date</th>
        <th align="center" width="240">modify date</th>
      </tr>
      <tr
        v-if="
          !serverList || (Array.isArray(serverList) && serverList.length === 0)
        "
      >
        <td colspan="4">현재 등록된 게시물이 없습니다!</td>
      </tr>
      <tr v-else v-for="(board, index) in serverList" :key="index">
        <td align="center">
          {{ board.hostNo }}
        </td>
        <td align="left">
          <router-link
            :to="{
              name: 'ProjectReadServerPage2',
              params: { hostName: board.hostName.toString() },
            }"
          >
            {{ board.hostName }}
          </router-link>
        </td>
        <td align="right">
          {{ board.ip }}
        </td>
        <!-- <td align="center">
          {{ aliveList[index] }}
        </td> -->
        <td align="center">
          {{ board.alive }}
        </td>
        <td align="center">
          {{ board.lastAliveDate }}
        </td>
        <td align="center">
          {{ board.createdDate }}
        </td>
        <td align="center">
          {{ board.lastModifiedDate }}
        </td>
      </tr>
    </table>
  </div>
</template>
<script>
export default {
  name: "ProjectList",
  props: {
    serverList: {
      type: Array,
      required: true,
    },
    // aliveList: {
    //   type: Array,
    //   required: true,
    // },
  },
};
</script>
<style lang=""></style>
