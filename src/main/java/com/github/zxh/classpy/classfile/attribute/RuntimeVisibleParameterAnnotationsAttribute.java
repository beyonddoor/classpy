package com.github.zxh.classpy.classfile.attribute;

import com.github.zxh.classpy.classfile.ClassComponent;
import com.github.zxh.classpy.classfile.reader.ClassReader;
import com.github.zxh.classpy.classfile.datatype.Table;
import com.github.zxh.classpy.classfile.datatype.U1;
import com.github.zxh.classpy.classfile.datatype.U2;
import com.github.zxh.classpy.classfile.attribute.RuntimeVisibleAnnotationsAttribute.AnnotationInfo;

/*
RuntimeVisibleParameterAnnotations_attribute {
    u2 attribute_name_index;
    u4 attribute_length;
    u1 num_parameters;
    {   u2         num_annotations;
        annotation annotations[num_annotations];
    } parameter_annotations[num_parameters];
}
 */
public class RuntimeVisibleParameterAnnotationsAttribute extends AttributeInfo {

    private U1 numParameters;
    private Table<ParameterAnnotationInfo> parameterAnnotations;
    
    @Override
    protected void readInfo(ClassReader reader) {
        numParameters = reader.readU1();
        parameterAnnotations = reader.readTable(ParameterAnnotationInfo.class,
                numParameters);
    }
    
    
    public static class ParameterAnnotationInfo extends ClassComponent {
        
        private U2 numAnnotations;
        private Table<AnnotationInfo> annotations;
        
        @Override
        protected void readContent(ClassReader reader) {
            numAnnotations = reader.readU2();
            annotations = reader.readTable(AnnotationInfo.class, numAnnotations);
        }
        
    }
    
}
