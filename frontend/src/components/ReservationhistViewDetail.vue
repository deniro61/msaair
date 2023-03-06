<template>

    <v-card outlined>
        <v-card-title>
            Reservationhist # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="ReservationId" v-model="item.reservationId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="CustomerId" v-model="item.customerId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="Mileage" v-model="item.mileage" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="ReservationStatus" v-model="item.reservationStatus" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'ReservationhistViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/reservationhists/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

