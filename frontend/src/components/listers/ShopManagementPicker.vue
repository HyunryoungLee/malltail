<template>
    <div>
        <v-list two-line v-if="list.length > 0">
            <v-list-item-group 
                    v-model="selected" 
                    color="indigo"
                    @change="select"
            >
                <v-list-item v-for="(item, idx) in list" :key="idx">
                    <template v-slot:default="{ active }">
                        <v-list-item-avatar color="grey darken-1">
                        </v-list-item-avatar>
                        
                        <v-list-item-content>
                            <v-list-item-title>
                            </v-list-item-title>
                            <v-list-item-subtitle>
                                OrderNo :  {{item.orderNo }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                CustomerId :  {{item.customerId }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                ItemNo :  {{item.itemNo }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                Qty :  {{item.qty }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                CreateDate :  {{item.createDate }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                OrderStatus :  {{item.orderStatus }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                DeliveryStatus :  {{item.deliveryStatus }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                CustomerAddress :  {{item.customerAddress }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                ShippingAddress :  {{item.shippingAddress }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                PayId :  {{item.payId }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                CustomerName :  {{item.customerName }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                PhoneNumber :  {{item.phoneNumber }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                ShopName :  {{item.shopName }}
                            </v-list-item-subtitle>
                        </v-list-item-content>

                        <v-list-item-action>
                            <v-checkbox :input-value="active" color="indigo"></v-checkbox>
                        </v-list-item-action>
                    </template>
                </v-list-item>
            </v-list-item-group>
        </v-list>
    </div>
</template>


<script>
    const axios = require('axios').default;

    export default {
        name: 'ShopManagementPicker',
        props: {
            value: [String, Object, Array, Number, Boolean],
        },
        data: () => ({
            list: [],
            selected: null,
        }),
        async created() {
            var me = this;
            var temp = await axios.get(axios.fixUrl('/shopManagements'))
            if(temp.data) {
                me.list = temp.data._embedded.shopManagements;
            }

            if(me.value && typeof me.value == "object" && Object.values(me.value)[0]) {
                var id = Object.values(me.value)[0];
                var tmpValue = await axios.get(axios.fixUrl('/shopManagements/' + id))
                if(tmpValue.data) {
                    var val = tmpValue.data
                    me.list.forEach(function(item, idx) {
                        if(item.name == val.name) {
                            me.selected = idx
                        }
                    })
                }
            }
        },
        methods: {
            select(val) {
                var obj = {}
                if(val != undefined) {
                    var arr = this.list[val]._links.self.href.split('/');
                    obj['id'] = arr[4]; 
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    this.$emit('selected', obj);
                }
            },
        },
    };
</script>

