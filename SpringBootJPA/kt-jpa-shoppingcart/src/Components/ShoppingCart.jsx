import React , {useState} from 'react'
import ProductList from './ProductList'


function Shoppingcart() {
    const [data, setData] = useState([
        {
            id: 1,
            name: "Sản phẩm 1",
            image: "https://images.unsplash.com/photo-1564584217132-2271feaeb3c5?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MzJ8fGNsb3RoZXN8ZW58MHx8MHx8&auto=format&fit=crop&w=800&q=60",
            price: 300000,
            count: 1,
            size : "M"
         },
         {
            id: 2,
            name: "Sản phẩm 2",
            image: "https://images.unsplash.com/photo-1564584217132-2271feaeb3c5?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MzJ8fGNsb3RoZXN8ZW58MHx8MHx8&auto=format&fit=crop&w=800&q=60",
            price: 300000,
            count: 1,
            size : "M"
         }
    ])
    

    const remove = (i) => {
        const arr = data.filter((item) => item.id !== i);
        if (window.confirm("Bạn có muốn xóa sản phẩm này không?") === true){
            setData(arr);
        }
    };
    
    const totalPrice = () => {
        let total = 0;
        data.forEach(item => {
            total += (item.price*item.count)
        });
        return total;
    }

    const increCount = (i) => {
        const newState = data.map(item => {
            if (item.id === i) {
              return {...item, count: item.count+1};
            }
            return item;
          });
        setData(newState);
    }

    const decreCount = (i) => {
        const newState = data.map(item => {
            if (item.id === i && item.count > 1 ) {
              return {...item, count: item.count-1};
            }
            return item;
          });
        setData(newState);
    }

    const cartCheck = () => {
        if (data.length===0){
            return "Không có sản phẩn trong giỏ hàng."
        } else {
            return "Có sản phẩm trong giỏ hàng."
        }
    }
    
    

    return (
        <div class="shopping-cart-container mt-5">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="mb-4">
                            <h2>Shopping Cart</h2>
                        </div>
                    </div>
                </div>
                <p class="fst-italic message">{cartCheck()}</p>
                <ProductList item={data} remove={remove} totalP={totalPrice} inc={increCount} dec={decreCount} />
            </div>
        </div>

    )
}

export default Shoppingcart