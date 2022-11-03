import React from 'react'

function ProductItem({item,remove,inc,dec}) {

    return (
        <div>
            {item.map((i,) => {
                return (
                    <div className="product-item d-flex border mb-4">
                    <div className="image">
                        <img src={i.image} alt={i.name} />
                    </div>
                    <div className="info d-flex flex-column justify-content-between px-4 py-3 flex-grow-1">
                        <div>
                            <div className="d-flex justify-content-between align-items-center">
                                <h2 className="text-dark fs-5 fw-normal">
                                    {i.name} ({i.size})
                                </h2>
                                <h2 className="text-danger fs-5 fw-normal">
                                    {i.price} VND
                                </h2>
                            </div>
                            <div className="text-black-50">
                                <div className="d-inline-block me-3">
                                    <button className="border py-2 px-3 d-inline-block fw-bold bg-light" onClick={() => dec(i.id)}>-</button>
                                    <span className="py-2 px-3 d-inline-block fw-bold">{i.count}</span>
                                    <button className="border py-2 px-3 d-inline-block fw-bold bg-light" onClick={() => inc(i.id)}>+</button>
                                </div>
                            </div>
                        </div>
                        <div>
                            <button className="text-primary border-0 bg-transparent fw-light" onClick={() => remove(i.id)}>
                                <span><i className="fa-solid fa-trash-can" ></i></span>
                                Xóa
                            </button>
                        </div>
                    </div>
                </div>
                )

            })}
        </div>

    )
}

export default ProductItem