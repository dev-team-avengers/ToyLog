import React, { useCallback } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { loadTvShowRequestAction } from '../reducers/tvShow';

const Home = () => {
    const dispatch = useDispatch();
    const { tvShowTitle, tvShowContents } = useSelector(state => state.tvShow);
    
    const onClickHero = useCallback((hero) => () => {
        dispatch(loadTvShowRequestAction(hero));
    }, []);

    return (
        <div>
            <button onClick={onClickHero('superman')}>슈퍼맨</button>
            <button onClick={onClickHero('batman')}>배트맨</button>
            <button onClick={onClickHero('catwoman')}>캣우먼</button>
            {tvShowTitle && <div>{tvShowTitle}</div>}
            <br />
            {tvShowContents && (
                <div>
                    {tvShowContents.map(show => (
                        <div key={show.id}>
                            <a href={show.url}>{show.name}</a>
                            <div>점수 : {show.name}</div>
                            <div>타입 : {show.type}</div>
                            <div>언어 : {show.language}</div>
                        </div>
                    ))}
                </div>
            )}
        </div>
    );
};

export default Home;