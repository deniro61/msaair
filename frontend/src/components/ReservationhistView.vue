<template>

    <v-data-table
        :headers="headers"
        :items="reservationhist"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'ReservationhistView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "reservationId", value: "reservationId" },
                { text: "customerId", value: "customerId" },
                { text: "mileage", value: "mileage" },
                { text: "reservationStatus", value: "reservationStatus" },
            ],
            reservationhist : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/reservationhists'))

            temp.data._embedded.reservationhists.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.reservationhist = temp.data._embedded.reservationhists;
        },
        methods: {
        }
    }
</script>

