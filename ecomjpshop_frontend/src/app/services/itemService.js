import baseApi from './baseService'

export const itemService = baseApi.injectEndpoints({
    endpoints: (builder) => ({
        getItems: builder.query({
            query: () => "/items"
        }),
        deleteItem: builder.mutation({
            query: (id) => ({
                url: `/items/${id}`,
                method: "DELETE"
            }),
            transformResponse: (response, meta, arg) => {
                return arg
            }
        }),
    })
})

export const { useGetItemsQuery, useDeleteItemMutation } = itemService