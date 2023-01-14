import baseApi from './baseService'

export const categoryService = baseApi.injectEndpoints({
    endpoints: (builder) => ({
        getCategories: builder.query({
            query: () => "/categories"
        }),
        deleteCategory: builder.mutation({
            query: (id) => ({
                url: `/categories/${id}`,
                method: "DELETE"
            }),
            transformResponse: (response, meta, arg) => {
                return arg
            }
        }),
        editCategory: builder.mutation({
            query: (data) => ({
                url: `/categories/${data.id}`,
                method: "PUT",
                body: data
            })
        }),
        createCategory: builder.mutation({
            query: (data) => ({
                url: "/categories",
                method: "POST",
                body: data
            })
        })
    })
})

export const { useGetCategoriesQuery, useDeleteCategoryMutation, useCreateCategoryMutation, useEditCategoryMutation } = categoryService