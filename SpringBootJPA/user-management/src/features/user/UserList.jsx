import React, {useState, useEffect} from "react";
import jsonList from "../json/MOCK_DATA.json"
import {Link} from "react-router-dom"



function UserList() {
    const [sTerm, setsTerm] = useState('')
    const [userList, setuserList] = useState(jsonList)


    useEffect(() => {
        const data = localStorage.getItem('currentList')
        if (data) {
            setuserList(JSON.parse(data));
        } else {
            localStorage.setItem('currentList', JSON.stringify(userList));
        }
    }, [])

/*     useEffect(() => {
        localStorage.setItem('currentList',JSON.stringify(userList))
    }, [userList]) */
    
    function handleDeleteUser (id) {
        const updatedUserList = [...userList].filter((user) => user.id !== id)
        localStorage.setItem('currentList', JSON.stringify(updatedUserList));
        setuserList(updatedUserList);
    }

    return (
        <div className="container mt-5 mb-5">
            <h2 className="text-center text-uppercase">Danh sách user</h2>

            <div className="row justify-content-center">
                <div className="col-md-10">
                    <div className="d-flex justify-content-between align-items-center mt-5 mb-4">
                        <Link to={{
                            pathname: "/UserAdd",
/*                             state: {userList} */
                        }}
                        className="btn">
                                Tạo user
                        </Link>
{/*                         <a className="btn btn-warning" >
                            Tạo user
                        </a> */}
                        <input
                            type="text"
                            id="search"
                            className="form-control w-50"
                            placeholder="Tìm kiếm user"
                            onChange={event => {setsTerm(event.target.value)
                            }}
                        />
                    </div>

                    <div className="bg-light p-4">
                        <table className="table table-hover">
                            <thead>
                                <tr>
                                    <th>STT</th>
                                    <th>Name</th>
                                    <th>Email</th>
                                    <th>Phone</th>
                                    <th>Address</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                {userList
                                .filter((user) => {
                                    if (sTerm === ""){
                                        return user;
                                    } else if (user.fullname.toLowerCase().includes(sTerm.toLowerCase())){
                                        return user;
                                    }
                                    return null;
                                })
                                .map((user,i) => (
                                    <tr key={i}>
                                        <td>{user.id}</td>
                                        <td>{user.fullname}</td>
                                        <td>{user.email}</td>
                                        <td>{user.phone}</td>
                                        <td>{user.address}</td>
                                        <td>
                                        <a
                                            href="./detail.html?id=2"
                                            className="btn btn-success"
                                        >
                                            Xem chi tiết
                                        </a>
                                        <button className="btn btn-danger"
                                        onClick={() => handleDeleteUser(user.id)}
                                        >
                                            Xóa
                                        </button>
                                        </td>
                                    </tr>
                                ))}
                            </tbody>
                        </table>

                        <p className="message d-none"></p>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default UserList;
