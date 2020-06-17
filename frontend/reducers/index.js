import { combineReducers } from 'redux';
import count from './count';
import tvShow from './tvShow';

const rootReducer = combineReducers({
    count,
    tvShow
});

export default rootReducer;