export const initialState = {
    tvShowTitle: '',
    tvShowContents: [],
    loadTvShowError: ''
};

export const LOAD_TVSHOW_REQUEST = 'LOAD_TVSHOW_REQUEST';
export const LOAD_TVSHOW_SUCCESS = 'LOAD_TVSHOW_SUCCESS';
export const LOAD_TVSHOW_FAILURE = 'LOAD_TVSHOW_FAILURE';

export const loadTvShowRequestAction = (data) => ({
    type: LOAD_TVSHOW_REQUEST,
    data
});

export const loadTvShowSuccessAction = (data) => ({
    type: LOAD_TVSHOW_SUCCESS,
    data
});

export const loadTvShowFailureAction = (error) => ({
    type: LOAD_TVSHOW_FAILURE,
    error
});

const reducer = (state = initialState, action) => {
    switch (action.type) {
        case LOAD_TVSHOW_REQUEST:
            return {...state, tvShowTitle: action.data};
        case LOAD_TVSHOW_SUCCESS:
            const tvShows = action.data.map(tvShow => ({
                id: tvShow.show.id,
                score: tvShow.score,
                url: tvShow.show.url,
                name: tvShow.show.name,
                type: tvShow.show.type,
                language: tvShow.show.language
            }))
            return {...state, tvShowContents: tvShows};
        case LOAD_TVSHOW_FAILURE:
            return {...state, loadTvShowError: action.error};
        default:
            return state;
    }
};

export default reducer;