import React from "react";
import { useSelector } from "react-redux";
import {
    useCreateCategoryMutation,
    useGetCategoriesQuery,
} from "../../../../app/services/categoryService";

function CategoryAdminList() {
    const { categories } = useSelector((state) => state.categories);
    const { isLoading } = useGetCategoriesQuery();
    const [createCategory] = useCreateCategoryMutation();

    // Tạo mới category
    const handleAddCategory = () => {
        const name = window.prompt("Enter name");

        if (name == null) {
            return;
        }

        if (name == "") {
            alert("Name không được để trống");
            return;
        }

        createCategory({ name })
            .unwrap()
            .then(() => alert("Tạo thành công"))
            .catch((err) => alert(err));
    };

    // Cập nhật category
    const handleEditCategory = (id) => {
        const category = categories.find((c) => c.id === id);
        const name = window.prompt("Enter update name", category.name);

        if (name == null) {
            return;
        }

        if (name == "") {
            alert("Name không được để trống");
            return;
        }

        // Gọi API cập nhật
    };

    if (isLoading) {
        return <h3>Loading ...</h3>;
    }

    return (
        <div className="course-list mt-4 mb-4">
            <div className="container">
                <div className="mb-4">
                    <button
                        className="btn-custom btn-create-course"
                        onClick={handleAddCategory}
                    >
                        Tạo category
                    </button>
                </div>

                <div className="course-list-inner p-2">
                    <table className="table course-table">
                        <thead>
                            <tr>
                                <th>STT</th>
                                <th>Tên category</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            {categories.map((category, index) => (
                                <tr key={category.id}>
                                    <td>{index + 1}</td>
                                    <td>{category.name}</td>
                                    <td>
                                        <button
                                            className="btn btn-info"
                                            onClick={() =>
                                                handleEditCategory(category.id)
                                            }
                                        >
                                            Edit
                                        </button>
                                        <button className="btn btn-danger">
                                            Delete
                                        </button>
                                    </td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    );
}

export default CategoryAdminList;
