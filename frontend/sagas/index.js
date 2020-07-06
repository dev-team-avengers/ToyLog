import { all, call } from 'redux-saga/effects';
import tvShow from './tvShow';

export default function* rootSaga() {
    yield all([
        call(tvShow)
    ]);
}