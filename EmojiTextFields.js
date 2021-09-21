import React, {forwardRef, useState} from 'react';
import {requireNativeComponent, Text, View} from 'react-native';

const EmojiTextView = requireNativeComponent('EmojiKeyboard');

const EmojiTextField = forwardRef((_, ref) => {
  const [count, setCount] = useState(0);

  const onChangeText = event => {
    const {count: emojiCount} = event.nativeEvent;
    setCount(emojiCount);
  };
  return (
    <>
      <View
        style={{
          width: '80%',
          height: 40,
          backgroundColor: 'white',
          alignItems: 'center',
          marginTop: 40,
          borderRadius: 20,
        }}>
        <EmojiTextView
          ref={ref}
          value={'😂🤣'}
          onTextChange={onChangeText}
          style={{
            width: '95%',
            borderRadius: 20,
            height: 40,
            justifyContent: 'flex-end',
            alignItems: 'flex-end',
          }}
        />
        <View
          style={{
            marginRight: 20,
            alignItems: 'flex-end',
            alignSelf: 'flex-end',
          }}>
          <Text>{count}/5</Text>
        </View>
      </View>
    </>
  );
});

export default EmojiTextField;
