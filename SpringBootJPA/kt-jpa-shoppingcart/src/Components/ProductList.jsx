import React, {useState} from 'react'
import ProductItem from './ProductItem'
import BillInfomation from './BillInfomation'


function ProductList({item, remove, totalP, inc, dec}) {

    return (
        <div class="row shopping-cart">
            <div class="col-md-8">
                <div class="product-list">
                    <ProductItem item={item} remove={remove} inc={inc} dec={dec}/>
                </div>
            </div>
            <BillInfomation totalP={totalP}/>
        </div>
    )
}

export default ProductList