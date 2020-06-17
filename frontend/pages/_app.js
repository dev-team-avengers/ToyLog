import React from 'react';
import withRedux, { createWrapper } from 'next-redux-wrapper';
import { Provider } from 'react-redux';
import { createStore, compose, applyMiddleware } from 'redux';
import reducer from '../reducers';
import { composeWithDevTools } from 'redux-devtools-extension';
import createSagaMiddleware from 'redux-saga';
import withReduxSaga from 'next-redux-saga';
import rootSaga from '../sagas';

const ToyLog = ({ Component, store }) => {    
    return (
        <Provider store={store}>
            <Component />
        </Provider>
    );
};

const configureStore = (initialState, options) => {
    const sagaMiddleware = createSagaMiddleware();
    const middlewares = [sagaMiddleware];
    const enhancer = process.env.NODE_ENV === 'production'?
        compose(applyMiddleware(...middlewares)):
        composeWithDevTools(applyMiddleware(...middlewares));
    
    const store = createStore(reducer, initialState, enhancer);
    store.sagaTask = sagaMiddleware.run(rootSaga);
    return store;
};

// export default withRedux(configureStore)(ToyLog);
// export default createWrapper(configureStore, { debug: true }).withRedux(ToyLog).withReduxSaga();
export default withRedux(configureStore)(withReduxSaga(ToyLog));