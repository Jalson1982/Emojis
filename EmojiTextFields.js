import React, {forwardRef} from 'react';
import {requireNativeComponent} from 'react-native';

const EmojiTextView = requireNativeComponent('EmojiKeyboard');

const EmojiTextField = forwardRef((_, ref) => {
  return (
    <EmojiTextView
      ref={ref}
      style={{width: '100%', height: 60, marginTop: 40}}
    />
  );
});

export default EmojiTextField;
