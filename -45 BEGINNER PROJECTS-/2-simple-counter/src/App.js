import React, {Component,} from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {
  constructor(props){
    super(props);
    this.state = {
      count:0
    }
  }
  
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

  increment = () => {
    this.setState({count: this.state.count+1})
  }

  decrement = () => {
    this.setState({count: this.state.count-1})
  }

  render() {
    return(
      <div className="App">
      <button onClick={this.increment} className='counter'>+</button>
      <button onClick={this.decrement} className='counter'>-</button>
      <h2>{this.state.count}</h2>
    </div>
    )
  };
}

export default App;
