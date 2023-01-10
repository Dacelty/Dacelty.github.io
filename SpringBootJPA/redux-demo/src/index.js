import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import Counter from './comp/counter';
import { Provider } from 'react-redux';
import store from './comp/redux/store/store';


const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <Provider store={store}>
      <Counter />
    </Provider>
  </React.StrictMode>
);

