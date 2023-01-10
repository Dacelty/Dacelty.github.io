import React from "react";
import { useSelector } from "react-redux";
import { Link } from "react-router-dom";
import {
    useGetItemsQuery,
    useDeleteItemMutation,
} from "../../../../app/services/itemService";
import { convertDate } from "../../../../utils/utils";

function BlogAdminList() {
    const { items } = useSelector((state) => state.items);
    const { isLoading } = useGetItemsQuery();
    const [deleteBlog] = useDeleteItemMutation();

    const handleDeleteBlog = (id) => {
        const isConfirm = window.confirm("Bạn có muốn xóa không?");
        if (isConfirm) {
            deleteBlog(id)
                .unwrap()
                .then(() => alert("Xóa thành công"))
                .catch((err) => console.log(err));
        }
    };

    if (isLoading) {
        return <h3>Loading ...</h3>;
    }

    return (
        <div className="course-list mt-4 mb-4">
            <div className="container">
                <div className="mb-4">
                    <Link
                        to={"/admin/blogs/create"}
                        className="btn-custom btn-create-course"
                    >
                        <span>
                            <i className="fa-solid fa-plus"></i>
                        </span>
                        Tạo bài viết
                    </Link>
                </div>

                <div className="course-list-inner p-2">
                    <table className="table course-table">
                        <thead>
                            <tr>
                                <th>Tên</th>
                                <th>Danh mục</th>
                                <th>Số lượng hàng tồn kho</th>
                                <th>Giá</th>
                                <th>Ngày tạo</th>
                                <th>Thời gian cập nhập</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            {items.map((item) => (
                                <tr key={item.id}>
                                    <td>
                                        {item.name}
                                    </td>
                                    <td>
                                        {item.category.name}
                                    </td>
                                    <td>
                                        {item.quantity}
                                    </td>
                                    <td>
                                        {item.price}
                                    </td>
                                    <td>
                                        {convertDate(item.createdAt)}
                                    </td>
                                    <td>

                                    </td>
                                    <td>
                                        <button
                                            className="btn btn-danger"
                                            onClick={() =>
                                                handleDeleteBlog(item.id)
                                            }
                                        >
                                            Xóa
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

export default BlogAdminList;
