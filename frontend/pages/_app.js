import React from 'react';
import withRedux, { createWrapper } from 'next-redux-wrapper';
import { Provider } from 'react-redux';
import { createStore, compose, applyMiddleware } from 'redux';
import reducer from '../reducers';
import { composeWithDevTools } from 'redux-devtools-extension';

const ToyLog = ({ Component, store }) => {
    // store = configureStore({count: 0}, {});
    console.log('====> ' + store);
    
    return (
        <Provider store={store}>
            <Component />
        </Provider>
    );
};

const configureStore = (initialState, options) => {
    const middlewares = [];
    const enhancer = process.env.NODE_ENV === 'production'?
        compose(applyMiddleware(...middlewares)):
        composeWithDevTools(applyMiddleware(...middlewares));
    
    const store = createStore(reducer, initialState, enhancer);
    console.log(initialState);
    return store;
};

// export default withRedux(configureStore)(ToyLog);
export default createWrapper(configureStore, { debug: true }).withRedux(ToyLog);