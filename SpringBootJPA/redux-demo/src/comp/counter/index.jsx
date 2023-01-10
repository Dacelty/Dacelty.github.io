import React from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { decrement, increment } from '../redux/action/counterAction';

function Counter() {

    const counter = useSelector((state) => state.counter)
    const dispatch = useDispatch();

    const incCounter = () => {
        dispatch(increment());
    }

    
    const decCounter = () => {
        dispatch(decrement());
    }

    return (
        <>
            <h2>Counter : {counter}</h2>
            <button onClick={incCounter}>Tăng</button>
            <button onClick={decCounter}>Giảm</button>
        </>
    )
}

export default Counter