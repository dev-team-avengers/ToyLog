import { all, fork, takeLatest, call ,put } from 'redux-saga/effects';
import axios from 'axios';
import { LOAD_TVSHOW_REQUEST, LOAD_TVSHOW_SUCCESS, LOAD_TVSHOW_FAILURE, loadTvShowSuccessAction, loadTvShowFailureAction } from '../reducers/tvShow';

function loadTvShowAPI(data) {
    return axios.get(`https://api.tvmaze.com/search/shows?q=${data}`);
}

function* loadTvShow(action) {
    try {
        const result = yield call(loadTvShowAPI, action.data);
        yield put(loadTvShowSuccessAction(result.data));
    } catch (e) {
        console.error(e);
        yield put(loadTvShowFailureAction(e));
    }
}

function* watchLoadTvShow() {
    yield takeLatest(LOAD_TVSHOW_REQUEST, loadTvShow);
}

export default function* tvShowSaga() {
    yield all([
        fork(watchLoadTvShow)
    ]);
}