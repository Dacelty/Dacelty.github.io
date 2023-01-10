import baseApi from './baseService'

export const blogService = baseApi.injectEndpoints({
    endpoints: (builder) => ({
        getBlogs: builder.query({
            query: () => "/items"
        }),
        deleteBlog: builder.mutation({
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

export const { useGetBlogsQuery, useDeleteBlogMutation } = blogService