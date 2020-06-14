import React, { useCallback } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { countPlusAction, countMinusAction } from '../reducers/count';

const Home = () => {
    const dispatch = useDispatch();
    const count = useSelector(state => state.count);
    
    const onClickPlus = useCallback(() => {
        dispatch(countPlusAction());
    }, []);

    const onClickMinus = useCallback(() => {
        dispatch(countMinusAction());
    }, []);

    return (
        <div>
            카운트 : {count}
            <button onClick={onClickPlus}>+</button>
            <button onClick={onClickMinus}>-</button>
        </div>
    );
};

export default Home;