import React from 'react';
import styled from 'styled-components';

const TestDiv = styled.div`
    background: yellow;
    height: 75px;
`;

const Header = () => {
    return (
        <TestDiv>
            테스트 div
        </TestDiv>
    );
};

export default Header;